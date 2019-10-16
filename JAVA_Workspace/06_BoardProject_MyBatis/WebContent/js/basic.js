addEvent = function(src, eventName, handler, useCapture){
	useCapture = useCapture || false;
	if( src.addEventListener){
		src.addEventListener( eventName, handler, useCapture);
	}else if(src.attachEvent) {
		src.attachEvent('on'+eventName, handler);
	}
}
removeEvent = function(src, eventName, handler){
	if( src.removeEventListener){
		src.removeEventListener( eventName, handler);
	}else if(src.attachEvent) {
		src.detachEvent('on'+eventName, handler);
	}
} 