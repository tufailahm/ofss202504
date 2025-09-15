function CalculatePi()
{
    var loop = document.getElementById("loop");
    var c = parseInt(loop.value);
    var f = parseFloat(loop.value);
    var Pi=0, n=1;

    try {
      if (isNaN(c) || f != c ) {
        throw("errInvalidNumber");
      } else if (c<=0) {
        throw("errNegativeNumber");
      }
	
      for (var i=0;i<=c;i++) {
        Pi=Pi+(4/n)-(4/(n+2));
        n=n+4;
      }
      document.getElementById("PiValue").innerHTML = Pi;
    } catch (e) {
      var msg = "Input Error: ";
      if (e=="errInvalidNumber")
        msg += "Invalid number.";
      else if (e=="errNegativeNumber")
        msg += "Input must be positive.";
      else
        msg += e.message;
		    
        alert(msg);
    }
}