//let btn = document.getElementById("r2");

/*btn.onclick = async ()=>{
    qselector="?value=pending";
    login();
}*/
/*async function login(e){
    e.preventDefault();
let Elem1 = document.getElementById("i1");
        let info = Elem1.value;
        let Elem2 = document.getElementById("i2");
        let info2 = Elem2.value;

        await fetch(`${domain}/employeepage`,{
            method: "POST",
            body: JSON.stringify({
                reimbamount: info,
                reimbdescription: info2,

            })
        })
        window.location.href = "./";
    }*/



/*window.addEventListener("load", async () => {
    let response = await fetch("http://localhost:9000/login");
    let result = await response.json();

    if(result.successful){
        window.location.href = `./${result.data.role.toLowerCase()}-dashboard`
    }else{
        window.location.href = "./";
    }
})*/

async function login(e){
    e.preventDefault(); //this prevents form onsubmit from refreshing

    let usernameInputElem = document.getElementById("username-input");
    //let passwordInputElem = document.getElementById("password-input");
    //let roleInputElem = document.getElementById("role-input");

    let response = await fetch("http://localhost:9000/login",{
        method: "POST",
        body: JSON.stringify({
            ersusername: usernameInputElem.value
            //password: passwordInputElem.value,
            //role: roleInputElem.value
        })
    })

    let result = await response.json();

    if(result.successful){
        getId();
        //window.location.href = `./${result.data.role.toLowerCase()}-dashboard`
    }else{
        window.location.href = "./";
    }

async function getId(){
    let usernameInputElem = document.getElementById("username-input");
    //let passwordInputElem = document.getElementById("password-input");
    let response = await fetch("http://localhost:9000/userid",{
        method: "POST",
        body: JSON.stringify({
            ersusername: usernameInputElem.value
            //password: passwordInputElem.value,
        })
    })
    let result = await response.json();
    //let result2 = getId2();
    //console.log(result2);
    /*if(result2 != null)
    window.location.href = `./employee-dashboard/${result2}`;*/
    if(result===0)
    window.location.href = `./employee-dashboard`;
    if(result===1)
    window.location.href = `./manager-dashboard`;
}
}
/*
async function getId2(){
    console.log("hi");
    let usernameInputElem = document.getElementById("username-input");
    //let passwordInputElem = document.getElementById("password-input");
    console.log("hi2");
    let response = await fetch("http://localhost:9000/user",{
        method: "POST",
        body: JSON.stringify({
            ersusername: usernameInputElem.value
            //password: passwordInputElem.value,
        })
    })
    console.log("hi3");
    let result = await response.json();

    return result;
}*/