function CalculatePi(loop)
{
  console.log("2. CalculatePI called")
    var c = parseInt(loop);
    var f = parseFloat(loop);
    var n=1;
    for (var i=0,Pi=0;i<=c;i++) {
      Pi=Pi+(4/n)-(4/(n+2));
      n=n+4;
    }
    self.postMessage({'PiValue': Pi});
}
//wait for the start 'CalculatePi' message
//e is the event and e.data contains the JSON object

self.onmessage = function(e)
{
  CalculatePi(e.data.value);
}