let domain = "http://localhost:9000";
let qselector ="";

window.addEventListener("load", async () => {
    let response = await fetch("http://localhost:9000/login");
    let result = await response.json();

    if(!result.successful){
        window.location.href = "./";
    }else{
        let info =result.data.ersusername;
        const info3 = getId2(info);
        info3.then(info2 => {
            console.log(info2);
            employeeReimbs(info2);
        })
    }
})


let btn4 = document.getElementById("r7");
let btn5 = document.getElementById("r8");
//let btn6 = document.getElementById("r9");

    btn4.onclick = async ()=>{
        let response = await fetch("http://localhost:9000/login");
    let result = await response.json();
    if(!result.successful){
        window.location.href = "./";
    }else{
        qselector="";
        let info =result.data.ersusername;
        const info3 = getId2(info);
        info3.then(info2 => {
            employeeReimbs(info2);
        })
    }    
    }
    btn5.onclick = async ()=>{
        let response = await fetch("http://localhost:9000/login");
    let result = await response.json();
    if(!result.successful){
        window.location.href = "./";
    }else{
        qselector="?value=employeepending";
        let info =result.data.ersusername;
        const info3 = getId2(info);
        info3.then(info2 => {
            employeeReimbs(info2);
        })
    }    
    }
    /*btn6.onclick = async ()=>{
        qselector="?value=one";
        employeeReimbs(info2)
    }*/

   async function employeeReimbs(info2){
    console.log(info2+' hi2')
        let response = await fetch(`${domain}/employeepage/${info2}${qselector}`)
        let data = await response.json();
        let reimbContainer = document.getElementById("r1");
        reimbContainer.innerHTML = "";
        data.forEach(reimb => {
            let reimbElem = document.createElement("div");
            reimbElem.className = "reimb-item";
            reimbElem.innerHTML = `Reimbursement id:${reimb.reimbid} Reimbursement amount:${reimb.reimbamount} Date submitted:${reimb.reimbsubmitted} Date resolved:${reimb.reimbresolved} Description:${reimb.reimbdescription} Author:${reimb.reimbauthor} Resolver:${reimb.reimbresolver} Status id:${reimb.reimbstatusid} Type id:${reimb.reimbtypeid}`;
            reimbContainer.appendChild(reimbElem);
       }); 
      // window.location.href = "./";
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
                reimbresolver: info4,
                reimbtypeid: info5
            })
        })
        window.location.href = "./";
    }

    async function getId2(info){
        let usernameInputElem = info;
        //document.getElementById("username-input");
        //let passwordInputElem = document.getElementById("password-input");
        let response = await fetch("http://localhost:9000/user",{
            method: "POST",
            body: JSON.stringify({
                ersusername: usernameInputElem
                //password: passwordInputElem.value,
            })
        })
        let result = await response.json();
        console.log(result+' hi');
        return result;
    }
