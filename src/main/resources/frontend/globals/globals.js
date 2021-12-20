async function logout(){
    await fetch("http://localhost:9000/login", {
        method: "DELETE"
    })

    window.location.href = ".."
}