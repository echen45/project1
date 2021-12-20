let domain = "http://localhost:9000";
let qselector ="";

window.addEventListener("load", async () => {
    let response = await fetch("http://localhost:9000/login");
    let result = await response.json();

    if(!result.successful){
        window.location.href = "./";
    }/*else{
        let info =result.data.ersusername;
        const info3 = getId2(info);
        info3.then(info2 => {
            //console.log(info2);
            //employeeReimbs(info2);
        })
    }*/
})

async function retrieveData(e){
    e.preventDefault();
    let response = await fetch("http://localhost:9000/login");
    let result = await response.json();
    if(!result.successful){
        window.location.href = "./";
    }else{
        let info =result.data.ersusername;
        const info3 = getId2(info);
        info3.then(info6 => {
            createReimb(info6);
        })
    }
}

async function createReimb(info6){
    //e.preventDefault();
    let Elem1 = document.getElementById("i1");
    let info = Elem1.value;
    let Elem2 = document.getElementById("i2");
    let info2 = Elem2.value;
    //let Elem3 = document.getElementById("i3");
    //let info3 = Elem3.value;
    //let Elem4 = document.getElementById("i4");
    //let info4 = Elem4.value;
    let Elem5 = document.getElementById("i5");
    let info5 = Elem5.value;
    await fetch(`${domain}/employeepage`,{
        method: "POST",
        body: JSON.stringify({
            reimbamount: info,
            reimbdescription: info2,
            reimbauthor: info6,
            //reimbresolver: info4,
            reimbtypeid: info5
        })
    })
    window.location.href = "./index.html";
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