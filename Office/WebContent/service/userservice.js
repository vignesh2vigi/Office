app.factory('UserService',function($http){
	var userService={}
	var BASE_URL="http://localhost:8080/Office"
	
	userService.register=function(user){
		return	$http.post(BASE_URL + "/servlet/Registration",user)
	}
	userService.login=function(user)
	{
	return $http.post(BASE_URL+"/servlet/login",user)
	}
	userService.logout=function()
	{
	return $http.get(BASE_URL+"/servlet/logout")
	}
	
	userService.details=function()
	{
	return $http.get(BASE_URL+"/servlet/details")
	}
	
	userService.userlist=function(){
		return	$http.get(BASE_URL + "/servlet/userlist")
	}
	
	userService.update=function(user){
		return	$http.post(BASE_URL + "/servlet/update",user)
	}
	
	return userService;
})