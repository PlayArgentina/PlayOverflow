$(document).ready(function() {
  $(".js-logout-btn").on("click", function() {
    $.post($(this).attr("href"), function() {
      window.location.reload();
    });
    return false;
  });
  $(".js_vote").on("click", function() {
	    $.get($(this).attr("href")), function () { 
	    	window.location.reload();
	    }
	  });
});