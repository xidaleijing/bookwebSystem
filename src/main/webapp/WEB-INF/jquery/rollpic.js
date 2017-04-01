$(document).ready((function() {
		$("#rollpic_caption").css("opacity", "0.4");
		$("#rollpic").cycle({
			fx : "fadeout",
			pauseOnHover : true,
			/*slides : "> a", 
			caption : "#rollpic_caption span",
			captionTemplate : "{{title}}"*/
			pager : "#rollpic_pager"
		});
	}))