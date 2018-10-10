$(function(){
	try {
		var setTitleFunc = setTitle;
		if(setTitleFunc && typeof setTitleFunc === 'function'){
			setTitleFunc(GLOBAL_CONFIG.title);
		}
	} catch (e) {
		
	}
});