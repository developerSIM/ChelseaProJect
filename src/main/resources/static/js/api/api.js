console.log( 'api.js open' )
// [2] 사업자 상태 조회 요청 함수
const api2 = ( ) => {
    // 1. 입력받은 데이터(사업자번호) 가져오기
    const 사업자번호입력상자 = document.querySelector('#사업자번호입력상자')
    const 사업자번호 = 사업자번호입력상자.value;
    // 2. 요청 자료 만들기 // 입력받은 사업자번호를 api 요청 형식에 맞게 구성
    const data = { "b_no" : [ 사업자번호.replaceAll('-','') ] } // 사업자번호에 '-' 있을경우 불가능하므로 replace 함수 이용하여 '-' 제거.
    // 3. url
    const url = 'https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey='
    // 4. 서비스 키 , 일반 인증키(Encoding)
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 5. fetch 이용한 API 요청
    const option = {
        method: 'POST' ,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( data )
    }
    fetch( url+serviceKey , option )
        .then( r => r.json() )
        .then( responseData => {
            console.log( responseData  )
            // 6. 만약에 요청 성공시 응답 자료 의 결과를 HTML 에 출력하기.
            const 결과구역 = document.querySelector('#결과구역')
            let html = responseData.data[0].tax_type
            결과구역.innerHTML = html
        })
        .catch( e => { console.log(e); } )
} // f end

// [1] 부평구 인구 현황 요청 함수
const api1 = ( ) => {
    // 1. 요청할 API URL
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=22&serviceKey='
    // 2. 요청할 API 인증 KEY , 개별 발급
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 3. fetch 이용한 API 통신
    fetch( url + serviceKey ) // url 과 serviceKey
        .then( response => response.json() )
        .then( responseData => { console.log( responseData );

            // (1) 출력할 DOM( HTML 를 객체 표현 ) 가져온다.
            const boardTable1 = document.querySelector('#boardTable1')
            // (2) 출력할 내용을 저장할 변수 선언한다.
            let html = '';
            // (3) 출력할 자료를 반복문 이용하여 여러개 자료를 html 문법 표현한다.
            responseData.data.forEach( ( obj ) => {
                // 객체내 속성값을 호출하는 방법 : 객체변수명.속성명 vs 객체변수명['속성명']
                // 객체내 속성값 호출시 주의할점 : 속성명에 특수문자가 있을경우에는 ['속성명'] 없으면 .속성명
                html +=`<tr>
                            <td> ${ obj['동별'] } </td>
                            <td> ${ obj['세대수'] } </td>
                            <td> ${ obj['인구수(계)'].toLocaleString()  } </td>
                            <td> ${ obj['인구수(남)'] } </td>
                            <td> ${ obj['인구수(여)'] } </td>
                        </tr>`
            }) // for end
            // (4) 출력할 DOM 에 생성한 HTML 대입하기.
            boardTable1.innerHTML = html;
        })
        .catch( error => { console.log( error ); } )
}
api1() // 함수 실행









// [1] 부평구 인구 현황 요청 함수
const api1 = ( ) => {
    // 1. 요청할 API URL
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=23&serviceKey='
    // 2. 요청할 API 인증 KEY , 개별 발급
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 3. fetch 이용한 API 통신
    fetch( url + serviceKey ) // url 과 serviceKey
        .then( response => response.json() )
        .then( responseData => { console.log( responseData );

            // (1) 출력할 DOM( HTML 를 객체 표현 ) 가져온다.
            const boardTable1 = document.querySelector('#boardTable1')
            // (2) 출력할 내용을 저장할 변수 선언한다.
            let html = '';
            // (3) 출력할 자료를 반복문 이용하여 여러개 자료를 html 문법 표현한다.
            responseData.data.forEach( ( obj ) => {
                // 객체내 속성값을 호출하는 방법 : 객체변수명.속성명 vs 객체변수명['속성명']
                // 객체내 속성값 호출시 주의할점 : 속성명에 특수문자가 있을경우에는 ['속성명'] 없으면 .속성명
                html +=`<tr>
                            <td> ${ obj['동별'] } </td>
                            <td> ${ obj['세대수'] } </td>
                            <td> ${ obj['인구수(계)'] } </td>
                            <td> ${ obj['인구수(남)'] } </td>
                            <td> ${ obj['인구수(여)'] } </td>
                        </tr>`
            }) // for end
            // (4) 출력할 DOM 에 생성한 HTML 대입하기.
            boardTable1.innerHTML = html;
        })
        .catch( error => { console.log( error ); } )
}
api1() // 함수 실행

api3();


