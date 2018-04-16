/**
 * 
 */
app.factory('MsgService',function($http){
	var msgService={}
	var BASE_URL="http://localhost:8080/Office"
		
		
		msgService.friend=function(sno)
		{
		return $http.get(BASE_URL+"/servlet/friend/"+sno)
		}
	
	msgService.addmsg=function(msg){
		return	$http.post(BASE_URL + "/servlet/addmsg2",msg)
	}
		return msgService;
})