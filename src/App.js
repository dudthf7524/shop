
import { Container, Nav, Navbar } from 'react-bootstrap';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import data from './data.js';
import { useState } from 'react';
import { Link, Outlet, Route, Routes, useNavigate } from 'react-router-dom';
import Detail from './routes/Detail.js';
function App() {
  let [shoes] = useState(data)
  let navigate = useNavigate()
  return (
    <div className='App' > 
      <Navbar bg="light" variant="light">
        <Container>
        <Navbar.Brand href="#home">ShoeShop</Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link href="/">Home</Nav.Link>
          <Nav.Link href="#features">Cart</Nav.Link>
          <Nav.Link href="/detail">상세페이지</Nav.Link>
          <Nav.Link onClick={()=>{ navigate(-1) }}>뒤로가기</Nav.Link>
          <Nav.Link onClick={()=>{ navigate(1) }}>앞으로가기</Nav.Link>
        </Nav>
        </Container>
      </Navbar>
      <Routes>
      <Route path="/" element={
        <>
          <div className="main-bg"></div>
            <div className="container">
              <div className="row">
                {/* <div className="col-md-4">
                <img src={process.env.PUBLIC_URL + '/logo192.png'} />             <h4>상품명</h4>
                <h4>상품명</h4>
                  <p>상품정보</p>
                </div> */}
                
                {/* {
                  shoes.map(function(a,i){
                    return(
                      <div className="col-md-4">
                        <img src={`https://codingapple1.github.io/shop/shoes${i+1}.jpg`} width="80%" />
                        <h4>{shoes[i].title}</h4>
                        <p>{shoes[i].content}</p>
                      </div> 
                    )
                    
                  })
                } */}
                {
                shoes.map(function(a,i){
                  return(
                    <Card shoes={shoes[i]} i={i+1} />
                  )
                })
              }
              
              </div>
          </div>
        </>
      } />
      
      
        <Route path="/detail/:id" element={ <Detail shoes={shoes}/> }/>        <Route path="/about" element={ <div>어바웃페이지임</div> } />
        <Route path="*" element={ <div>없는페이지임</div> } />
        <Route path="/event" element={<EventPage/>}>
          <Route path="one" element={<p>첫 주문시 양배추즙 서비스</p>}></Route>
          <Route path="two" element={<p>생일기념 쿠폰받기</p>}></Route>
        </Route>
      </Routes>
    </div>
    
  );
}

function Card(props){
  return (
    <div className="col-md-4">
      <img src={'https://codingapple1.github.io/shop/shoes' + props.i + '.jpg'} width="80%" />
      <h4>{ props.shoes.title }</h4>
      <p>{ props.shoes.price }</p>
    </div>
  )
}
function EventPage(){
  return (
    <div>
      <h4>오늘의 이벤트</h4>
      <Outlet></Outlet>
    </div>
  )
} 

export default App;
