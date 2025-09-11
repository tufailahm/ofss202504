function setCookie(name, value) {        //firstname, Tufail
    var dt = new Date();        //system date   
    dt.setDate(dt.getDate() + 1);       //12th Sep
    document.cookie = name + "=" + escape(value) + "; expires=" + dt.toGMTString();
}
function getCookie(name)        //lastName
{  //'firstName=Harish; lastName=Khurana; mobileNumber=987654321'
    if (document.cookie.length > 0) {
        ind = document.cookie.indexOf(name);    
        console.log("ind :"+ind); //18
        if (ind != -1) {
            ind = ind + name.length + 1;        //26
                ind1 = document.cookie.indexOf(";", ind);
            if (ind1 == -1) 
                ind1 = document.cookie.length;
            return unescape(document.cookie.substring(ind, ind1));
        }
    }
    return "";
}