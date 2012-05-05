$(document).ready(function() {
  $(".js-logout-btn").on("click", function() {
    $.post($(this).attr("href"), function() {
      window.location.reload();
    });
    return false;
  });
  $(".vote").on("click", function() {
	    $.post($(this).attr("href"), function() {
	      window.location.reload();
	    });
	    return false;
	  });
});