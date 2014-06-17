/**
 * 自动弹出树形选择器
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/05/10
 */
//load css and js
$.getScript("/static/ztree/js/jquery.ztree.all-3.5.min.js");
$('head').append('<link href="/static/ztree/css/zTreeStyle.css" rel="stylesheet">');

$(document).ready(
function() {
	$("._autoPopTree").each(function() {
		var _k = $(this).attr("id");
		_autoZTree(_k);
	});
});

function _autoZTree(key){
	var ___key = key;
	var _target = $("#" + ___key);
	if(_target){
		var selectDepDivStr = '<div id="_' + ___key + 'Div" class="modal hide fade" tabindex="-1" data-backdrop="false" role="dialog" aria-labelledby="catLabel" aria-hidden="true" style="z-index:999999">' +
								'<div class="modal-header">' + 
									'<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>' +
									'<h3>' + _target.attr("_title") + '</h3>' +
								'</div>' +
								'<div id="content-left"' +
								'	style="float: left; display: inline;">' +
								'	<div class="box-content"' +
								'		style="margin-top: 5px; margin-left: 10px;">' +
								'		<ul id="_' + ___key + 's" class="ztree"></ul>' +
								'	</div>' +
								'</div>' +
							'</div>';
		$( "body" ).append(selectDepDivStr);
		
		var pIdKey = _target.attr("_pIdKey") || 'pId';
		var idKey = _target.attr("_idKey") || 'id';
		var children = _target.attr("_children") || 'children';
		var name = _target.attr("_name") || "name";
		var selectParent = _target.attr("_selectParent") || false;
		/**
		 * select node: ignore parent node if selectParent is false
		 */
		function selectNode(event, treeId, treeNode) {
			if (!treeNode.isParent || selectParent) {
				_target.val(treeNode[name]);
				_target.attr("_id", treeNode[idKey]);
				$("#_" + ___key + "Div").modal('hide');
				var callback = _target.attr("_callback");
				if(callback){
					eval(callback);
				}
			}
		}
		
		//options
		var setting = {
			data : {
				simpleData : {
					enable : true,
					pIdKey : pIdKey,
					idKey : idKey,
					rootPId : 1
				},
				key:{
					children:children,
					name: name
				}
			},
			callback : {
				onClick : selectNode
			}
		};

		//load data
		var url = _target.attr("_url");
		$.ajax({
			url : BI_PATH_BASE + url,
			type : "GET",
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					var data = result.data;
					data.open = true;
					$.fn.zTree.init($("#_" + ___key + "s"), setting, data);
				}
			},
			error : function() {
				//bootbox.alert("fail!");
			}
		});
		
		//show tree
		_target.focus(function(){
			$("#_" + ___key + "Div").modal();
		});
	}
}
