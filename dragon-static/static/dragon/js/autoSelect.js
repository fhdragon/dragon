/**
 * auto select list
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/05/22
 */
$(document).ready(function() {
	//auto select init by '_autoSelect' class
	$("._autoSelect").each(function() {
		var _k = $(this).attr("id");
		_autoSelect(_k);
	});
	
	/**
	 * auto select function
	 * 
	 * @param key
	 */
	function _autoSelect(key) {
		var ___key = key;
		var _target = $("#" + ___key);
		if (_target) {
			//load data from url
			var url = _target.attr("_url");
			$.ajax({
				url : BI_PATH_BASE + url,
				type : "GET",
				dataType : "json",
				success : function(result) {
					if (result.code == 0) {
						var data = result.data;
						var r = "";
						var _value = _target.attr("_value") || 'value';
						var _name = _target.attr("_name") || "name";
						for(var i = 0, maxi = data.length; i < maxi; i++){
							r += ('<option value="' + data[i][_value] + '">' + data[i][_name] + '</option>');
						}
						_target.append(r);
					}
				},
				error : function(e) {alert(e);
//					bootbox.alert("fail!");
				}
			});
		}
	}
});

