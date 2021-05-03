async function login(){
	var XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       // Typical action to be performed when the document is ready:
	        var result = XHR.responseText;
	        /*var result=JSON.parse(response);*/
	        console.log(result);


     if(result=="admin"){
    window.location.href="userList.html";
    }else{
     window.location.href="user.html";
}
}
	};
	var td=document.getElementById("name").value;
	XHR.open("GET","/getLogin?user_name="+document.getElementById("name").value+"&password="+document.getElementById("password").value, true);
	localStorage.setItem("user_name",td);
    XHR.setRequestHeader("Authorization", "Bearer "+localStorage.getItem("token"));

	XHR.send();

	}


	function insertManualProduction(){
    		 var XHR2 = new XMLHttpRequest();
             var hash={"username":"hisGroup","password":"password"}

    		XHR2.open("POST", "/authenticate");
    		XHR2.setRequestHeader("Content-Type", "application/json;charset=UTF-8");


    	XHR2.onload = function() {
    	          console.log(XHR2.responseText);
    	          var response = JSON.parse(XHR2.responseText);
    	          console.log(response)
    	         localStorage.setItem("token",response.token)
    	      }


    	XHR2.send(JSON.stringify(hash));

    }

    insertManualProduction();