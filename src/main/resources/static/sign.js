function getLogin(){

        var name=document.getElementById("name").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var ComName = document.getElementById("ComName").value;
        var type = document.getElementById("type").value;

        if(name!=""&&password!=""&&email!=""&&ComName!=""){
         var temp = {
                "user_name":name,
                "password":password,
                "email":email,
                "comp_name":ComName,
                "user_type":type


            }

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    console.log(this.responseText);
                    if(this.responseText == "Inserted" ){

                        document.getElementById("name").value = "";
                        document.getElementById("password").value = "";
                        document.getElementById("email").value = "";
                        document.getElementById("ComName").value = "";
                        document.getElementById("type").value = "";

                         Toastify({
                                                   text: "User Added ",
                                                   duration: 3000,
                                                   gravity: "top",
                                                   position: 'center',
                                                   backgroundColor: "Green",
                                                   close : true
                                                }).showToast();
                          setTimeout(function (){
                          window.location.href='userList.html';
                          },3000)


                      }
                      else{
                        Toastify({
                           text: "Server ERROR !! ",
                           duration: 3000,
                           gravity: "top",
                           position: 'center',
                           backgroundColor: "#ff0000",
                           close : true
                        }).showToast();
                      }
                 }
            };
            xhttp.open("POST","/insertLogin", true);
            xhttp.setRequestHeader("Content-type", "application/json");
             xhttp.setRequestHeader("Authorization", "Bearer "+localStorage.getItem("token"));

            xhttp.send(JSON.stringify(temp));

        }else{
        Toastify({
                                   text: "Please Enter Data ",
                                   duration: 3000,
                                   gravity: "top",
                                   position: 'center',
                                   backgroundColor: "#ff0000",
                                   close : true
                                }).showToast();
        }
console.log("working");
}