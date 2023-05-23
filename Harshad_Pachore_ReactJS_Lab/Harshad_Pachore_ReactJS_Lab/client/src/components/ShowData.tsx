import { useEffect, useState } from "react";
import DataList from "../model/DataList";
import { getDataFromServer } from "../services/menu";
import ExpenseTracker from "./ExpenseTracker";

export default function ShowData(){

    const [items, setItems] = useState<DataList[]>([]);
    const [error, setError] = useState<Error|null>(null);
    const [sum, setSum] = useState<number|null>(0);
    const [yashSpent, setYashSpent] =  useState<number>(0);
    const [harshSpent, setHarshSpent] =  useState<number>(0);
    const [showForm, setShowForm] = useState<boolean>(false);

    useEffect(()=>{
        const fetchMenu = async () => {
            try{
                const data = await getDataFromServer();
                console.log(data);
                setItems(data);
                setSum(data.reduce((result,v) =>  result + v.price , 0 ))
                calculateShares(data);
            }
            catch(error: any){
                console.error(error);
                setError(error);
            }
        }
        fetchMenu();
    },[showForm]);
 
    const calculateShares = (data: DataList[]) => {
        var yashspent1 : number = 0
        var harshspent1 : number = 0
        data.map(
            sams => (
                sams.payeeName === "Yash" ? (
                    yashspent1 = yashspent1 + sams.price
                ):
                (
                    harshspent1 = harshspent1 + sams.price
                )
            )
        )
        setYashSpent(yashspent1)
        setHarshSpent(harshspent1)
    }

    return (
        <>
            <header id="page-Header">Expense Tracker</header>
            <button id="Add-Button" onClick={()=>setShowForm(true)}>Add</button>
            {
                showForm && (
                    <div className="form">
                        <ExpenseTracker onTrue={()=>setShowForm(false)} onClose={()=>setShowForm(false)}></ExpenseTracker>
                    </div>
                )
            }
            <>
                <div className="use-inline date header-color">Date</div>
                <div className="use-inline header-color">Product Purchased</div>
                <div className="use-inline price header-color">Price</div>
                <div className="use-inline header-color" style={{width: 112}}>Payee</div>
            </>
            {
                items && items.map ((user,idx)=>{
                    return (<div key={idx}>
                        <div className="use-inline date">{user.setDate}</div>
                        <div className="use-inline">{user.product}</div>
                        <div className="use-inline price">{user.price}</div>
                        <div className={`use-inline ${user.payeeName}`}>{user.payeeName}</div>
                    </div>)
                })
            }
        <hr/>
        <div className="use-inline ">Total: </div>
        <span className="use-inline total">{sum}</span> <br />
        <div className="use-inline ">Yash paid: </div>
        <span className="use-inline total Yash">{yashSpent}</span> <br />
        <div className="use-inline ">Harsh paid: </div>
        <span className="use-inline total Harsh">{harshSpent}</span> <br />
        <span className="use-inline payable">{yashSpent>harshSpent? "Pay Yash " : "Pay Harsh"}</span>
        <span className="use-inline payable price"> {Math.abs((yashSpent-harshSpent)/2)}</span>
        {
               error && (
                    <>
                        {error?.message}
                    </>
                )
            } 
        </>
    );
}