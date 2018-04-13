app.factory('BlogService',function($http){
	var blogService={}
	var BASE_URL="http://localhost:8080/Office"
	
		blogService.list=function(){
		return	$http.get(BASE_URL + "/servlet/getblog")
	}
	
	blogService.waitlist=function(){
		return	$http.get(BASE_URL + "/servlet/waitlist")
	}
	blogService.addblog=function(blog){
		return	$http.post(BASE_URL + "/servlet/addblog",blog)
	}
	blogService.blogapp=function(id){
		return	$http.post(BASE_URL + "/servlet/blogapp/"+id)
	}
	blogService.blogrej=function(id){
		return	$http.post(BASE_URL + "/servlet/blogrej/"+id)
	}
	return blogService;
})