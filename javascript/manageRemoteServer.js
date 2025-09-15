var a = new XMLHttpRequest();
var data = null;
function getDataFromRemoteServer(filename){
    a.open("GET",filename,false);
    a.onreadystatechange = fetchData;
    a.send(null);
    return data;
}
function fetchData(){
    if(a.readyState == 4){
        data = a.responseText;
    }
}