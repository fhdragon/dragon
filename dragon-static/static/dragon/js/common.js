$(document).ready(function() {
    /**Begin: add by Wenlong Meng at 2014/05/12 for Enter event**/
    //return event: eg, <input type="text" id="test" class="_autoReturnEvent" _returnEvent="jsFunc()">
	$("._autoReturnEvent").each(function() {
		$(this).keydown(function(e) {
			if (e.keyCode == 13) {
				var _k = $(this).attr("_returnEvent");
				eval(_k);
			}
		});
	});
    /**End: add by Wenlong Meng at 2014/05/12 for Enter event**/
});
