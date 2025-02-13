
// [1] 수정페이지 들어왔을때 수정 하기전 기존 정보 보여주기
const getMyInfo = ( ) => {

    fetch('/member/myinfo.do' , { method : 'GET' } )
    .then( response => response.json() )
    .then( data => {
        if( data != ''){
            document.querySelector('.midInput').value = data.mid;
            document.querySelector('.mnameInput').value = data.mname;
            document.querySelector('.memailInput').value = data.memail;
        }
    }).catch( e => { console.log(e) })
};
getMyInfo(); // update.html 이 열릴때 내정보 조회 함수 

// [2] 수정 버튼 클릭했을때. 수정처리 
const onUpdate = ( ) => {
    // 1. 입력받은 input value 값 가져오기.
    let mname = document.querySelector('.mnameInput').value;
    let memail = document.querySelector('.memailInput').value;
    // 2. 객체화
    let dataObj = { mname : mname , memail : memail }
    // 3. fetch 
    const option = {
        method : 'PUT' , 
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify( dataObj )
    }// o end 
    fetch( '/member/update.do' , option )
    .then( response => response.json() )
    .then( data => {
        if( data ){ alert('수정 성공'); location.href="/member/info"; }
        else{ alert('수정 실패');}
    }).catch( e => { console.log(e); } )
} // f end 