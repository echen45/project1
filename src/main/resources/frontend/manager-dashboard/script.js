let domain = "http://localhost:9000";
let qselector ="";

window.addEventListener("load", async () => {
    let response = await fetch("http://localhost:9000/login");
    let result = await response.json();

    let info =result.data.ersusername;
    /*const info3 = getId2(info);
    info3.then(info6 => {
        createReimb(info6);
    })*/

    if(!result.successful){
        window.location.href = "./";
    }else{
        getId(info);
    }
})

/*window.addEventListener("load", () => {
    getAllReimbs();
})*/

let btn = document.getElementById("r2");
let btn2= document.getElementById("r3");
let btn3 = document.getElementById("r4");
let btn4 = document.getElementById("r7");
let btn5 = document.getElementById("r8");
let btn6 = document.getElementById("r9");

    btn.onclick = async ()=>{
        qselector="?value=pending";
        getAllReimbs();
    }
    btn2.onclick = async ()=>{
        qselector="?value=approved";
        getAllReimbs();
    }
    btn3.onclick = async ()=>{
        qselector="?value=denied";
        getAllReimbs();
    }
    btn4.onclick = async ()=>{
        qselector="";
        employeeReimbs()
    }
    btn5.onclick = async ()=>{
        qselector="?value=employeepending";
        employeeReimbs()
    }
    btn6.onclick = async ()=>{
        qselector="?value=one";
        employeeReimbs()
    }

    async function createUser(e){
        e.preventDefault();
        let Elem1 = document.getElementById("w1");
        let info = Elem1.value;
        let Elem2 = document.getElementById("w2");
        let info2 = Elem2.value;
        let Elem3 = document.getElementById("w3");
        let info3 = Elem3.value;
        let Elem4 = document.getElementById("w4");
        let info4 = Elem4.value;
        let Elem5 = document.getElementById("w5");
        let info5 = Elem5.value;
        let Elem6 = document.getElementById("w6");
        let info6 = Elem6.value;
        await fetch(`${domain}/managerpage`,{
            method: "POST",
            body: JSON.stringify({
                ersusersid: info,
                ersusername: info2,
                userfirstname: info3,
                userlastname: info4,
                useremail: info5,
                userroleid: info6
            })
        })
        window.location.href = "./";
    }

   async function employeeReimbs(){
    let Elem1 = document.getElementById("z1");
    let info = Elem1.value;
        let response = await fetch(`${domain}/employeepage/${info}${qselector}`)
        let data = await response.json();
        let reimbContainer = document.getElementById("r1");
        reimbContainer.innerHTML = "";
        console.log('hi');
        data.forEach(reimb => {
            let reimbElem = document.createElement("div");
            reimbElem.className = "reimb-item";
            reimbElem.innerHTML = `${reimb.reimbid}+${reimb}`;
            reimbContainer.appendChild(reimbElem);
       }); 
       //window.location.href = "./";
    }

    async function deleteUser(e){
        let Elem1 = document.getElementById("y1");
        let info = Elem1.value;
        await fetch(`${domain}/managerpage`,{
            method: "DELETE",
            body: JSON.stringify({
                ersusersid: info
        })
     })
     window.location.href = "./";
    }

    async function approvedeny(e){
        let Elem1 = document.getElementById("x1");
        let info = Elem1.value;
        let Elem2 = document.getElementById("x2");
        let info2 = Elem2.value;
        await fetch(`${domain}/managerpage`,{
            method: "PATCH",
            body: JSON.stringify({
                reimbid: info,
                reimbtypeid: info2
            })
        })
        window.location.href = "./";
    }

    async function createReimb(e){
        e.preventDefault();
        let Elem1 = document.getElementById("i1");
        let info = Elem1.value;
        let Elem2 = document.getElementById("i2");
        let info2 = Elem2.value;
        let Elem3 = document.getElementById("i3");
        let info3 = Elem3.value;
        let Elem4 = document.getElementById("i4");
        let info4 = Elem4.value;
        let Elem5 = document.getElementById("i5");
        let info5 = Elem5.value;
        await fetch(`${domain}/employeepage`,{
            method: "POST",
            body: JSON.stringify({
                reimbamount: info,
                reimbdescription: info2,
                reimbauthor: info3,
                //reimbresolver: info4,
                reimbtypeid: info5
            })
        })
        window.location.href = "./";
    }

async function getAllReimbs(){
    let response = await fetch(`${domain}/employeepage${qselector}`)
    let data = await response.json();
    let reimbContainer = document.getElementById("r1");
    reimbContainer.innerHTML = "";
    data.forEach(reimb => {
        let reimbElem = document.createElement("div");
        reimbElem.className = "reimb-item";
        reimbElem.innerHTML = `Reimbursement id:${reimb.reimbid} Reimbursement amount:${reimb.reimbamount} Date submitted:${reimb.reimbsubmitted} Date resolved:${reimb.reimbresolved} Description:${reimb.reimbdescription} Author:${reimb.reimbauthor} Resolver:${reimb.reimbresolver} Status id:${reimb.reimbstatusid} Type id:${reimb.reimbtypeid}`;
        reimbContainer.appendChild(reimbElem);
   }); 
}

async function getId(info){
    let usernameInputElem = info;
    //let passwordInputElem = document.getElementById("password-input");
    let response = await fetch("http://localhost:9000/userid",{
        method: "POST",
        body: JSON.stringify({
            ersusername: usernameInputElem
            //password: passwordInputElem.value,
        })
    })
    let result = await response.json();
    if(result===0)
    window.location.href = `../employee-dashboard`;
    else if(result===1)
    getAllReimbs();
    //.location.href = `./manager-dashboard`;
    else
    window.location.href = "./";
}

/*btn.onclick = async () => {
    let response = await fetch(`${domain}/employeepage?value=pending`);
    let data = await response.json();
    let reimbContainer = document.getElementById("r1");
reimbContainer.className= "reimb2";
reimbContainer.innerHTML = "";
data.forEach(reimb => {
    let reimbElem = document.createElement("div");
    reimbElem.className = "reimb-item";
    reimbElem.innerHTML = `${reimb.reimbid}+${reimb}`;
    reimbContainer.appendChild(reimbElem);
}); 
}*/