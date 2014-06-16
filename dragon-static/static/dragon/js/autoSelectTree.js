/**
 * 自动弹出树形选择器
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/05/10
 */
$('head').append('<link href="/static/ztree/css/zTreeStyle.css" rel="stylesheet">');
$('head').append('<script src="/static/ztree/js/jquery.ztree.all-3.5.min.js"></script>');
$(document).ready(function() {
	$("._autoPopTree").each(function() {
		var _k = $(this).attr("id");
		_autoZTree(_k);
	});
});

function _autoZTree(key) {
	var ___key = key;
	var _target = $("#" + ___key);
	if (_target) {
		var selectDepDivStr = '<div id="_'
				+ ___key
				+ 'Div" class="modal hide fade" style="z-index:999999;margin:0;position: absolute;" data-backdrop="false">'
				+ '<div class="modal-header" style="padding:0 5px;">'
				+ '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>'
				+ '</div>' + '<ul id="_' + ___key + 's" class="ztree"></ul>'
				+ '</div>';
		$("body").append(selectDepDivStr);
		// var _targetOffset = _target.offset();
		// $("#_" + ___key + "Div").css({left:_targetOffset.left + "px",
		// top:_targetOffset.top + _target.outerHeight() + "px", width:
		// _target.outerWidth()});

		var pIdKey = _target.attr("_pIdKey") || 'pId';
		var idKey = _target.attr("_idKey") || 'id';
		var children = _target.attr("_children") || 'children';
		var name = _target.attr("_name") || "name";
		/**
		 * 双击选择逻辑：忽略根节点
		 */
		function selectNode(event, treeId, treeNode) {
			// 忽略根节点
			if (treeNode.pid != -1) {
				_target.val(treeNode[name]);
				_target.attr("_val", treeNode[name]);
				_target.attr("_id", treeNode[idKey]);
				$("#_" + ___key + "Div").modal('hide');
				var callback = _target.attr("_callback");
				if (callback) {
					eval(callback);
				}
			}
		}

		// 组织机构树设置
		var setting = {
			data : {
				simpleData : {
					enable : true,
					pIdKey : pIdKey,
					idKey : idKey,
					rootPId : 1
				},
				key : {
					children : children,
					name : name
				}
			},
			callback : {
				onClick : selectNode
			}
		};
		// 加载组织结构数据
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
//				bootbox.alert("操作失败!");
			}
		});
		//点击其他地方隐藏树
		$(document).click(function(e) {
			var e = e || window.event; // 浏览器兼容性
			var elem = e.target || e.srcElement;
			while (elem) { // 循环判断至跟节点，防止点击的是div子元素
				if (elem.id && ((elem.id == "_" + ___key + "Div") || (elem.id == ___key))) {
					return;
				}
				elem = elem.parentNode;
			}
			$("#_" + ___key + "Div").modal('hide');
		});
		/* 保存 */
		_target.focus(function() {
			var _targetOffset = _target.offset();
			$("#_" + ___key + "Div").css({
				left : _targetOffset.left + "px",
				top : _targetOffset.top + _target.outerHeight() + "px",
				width : _target.outerWidth()
			});
			$("#_" + ___key + "Div").modal();
		});
	}
}
