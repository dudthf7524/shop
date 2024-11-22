import { useParams } from "react-router-dom";

function Detail(props){
    let {id} = useParams();
    let numericId = parseInt(id);
    numericId = numericId+1;
    let 찾은상품 = props.shoes.find(function(x){
        console.log(x)
        return x.id == id
    });
    console.log(찾은상품)
    return(
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                <img src={'https://codingapple1.github.io/shop/shoes' + numericId + '.jpg'} width="80%" />
                </div>
                <div className="col-md-6">
                <h4 className="pt-5">{찾은상품.title}</h4>
                <p>{찾은상품.content}</p>
                <p>{찾은상품.price}원</p>
                <button className="btn btn-danger">주문하기</button> 
                </div>
            </div>
        </div>
    )
}
export default Detail;