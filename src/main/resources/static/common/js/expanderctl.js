/**
* 用一个按钮控制展开另一个dom区域
**/

function DomExpanderCtl(ctlNodeId,showNodeId,extralConfig){
	this.times = 0; 						//表示展开的次数
	this.ctlNodeId = ctlNodeId;				//控制div 
	this.showNodeId = showNodeId;			//被控制的div
	this.ctlNode = document.getElementById(ctlNodeId);
	this.showNode = document.getElementById(showNodeId);

	//配置信息
	this.configs = {
		"expandCss":"expand-css",
		"collapseCss":"collapse-css",
		"baseCss":""
	}

	//初始化参数信息
	for(var item in extralConfig){
		this.configs[item] = extralConfig[item];
	}

	//bind click listener to ctlNode
	this.bind(this);
}

//bind click listener
DomExpanderCtl.prototype.bind = function(self){
	var _ctlNode = self.ctlNode;
	var _showNode = self.showNode;
	var _expandCss = self.configs["expandCss"];
	var _collapseCss = self.configs["collapseCss"];
	var _baseCss = self.configs["baseCss"];
	//bind click listener to ctlNode
	_ctlNode.onclick = function(){
		console.log(self.times);
		if(0 == self.times % 2){
			_showNode.className = _baseCss+" "+_expandCss;
		}else{
			_showNode.className = _baseCss+" "+_collapseCss;
		}
		self.times+=1;
	}
}


