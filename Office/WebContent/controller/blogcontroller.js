app.controller('BlogController',function($scope,BlogService,$location,$rootScope,$cookieStore,$route,$window)
		{
	function list() {
		BlogService.list().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			 
			$scope.blogdetails = response.data
		
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	
	function waitlist() {
		BlogService.waitlist().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			 
			$scope.wait = response.data
		
		}, function(response) {
			console.log(response.status)
			if(response.status==401){
	    	
				$location.path('/login')
			}
		})
	}
	
	$scope.addblog=function(){	
		console.log("hi===="+$scope.blog)
	
	BlogService.addblog($scope.blog).then(function(response){
			console.log(response.data)
			console.log(response.status)
			/*alert('Updated successfully')*/
			$route.reload();
			$window.location.reload();
			$location.path('/getblog')
		},function(response){
			if(response.status==401){
				$location.path('/login')
			}
			else{
				/*$scope.error=response.data*/
				$location.path('/login')
				}			
			console.log(response.data)
			console.log(response.status)
	})
		}
	
	
	$scope.blogapp=function(blog){	
		console.log("id===="+blog.blogid)
	var id=blog.blogid
	console.log("id===="+id)
	BlogService.blogapp(id).then(function(response){
			console.log(response.data)
			console.log(response.status)
			/*alert('Updated successfully')*/
			$route.reload();
			$window.location.reload();
			$location.path('/getblog')
		},function(response){
			if(response.status==401){
				$location.path('/login')
			}
			else{
				/*$scope.error=response.data*/
				$location.path('/login')
				}			
			console.log(response.data)
			console.log(response.status)
	})
		}
	
	$scope.blogrej=function(blog){	
		console.log("id===="+blog.blogid)
	var id=blog.blogid
	console.log("id===="+id)
	BlogService.blogrej(id).then(function(response){
			console.log(response.data)
			console.log(response.status)
			/*alert('Updated successfully')*/
			$route.reload();
			$window.location.reload();
			$location.path('/getblog')
		},function(response){
			if(response.status==401){
				$location.path('/login')
			}
			else{
				/*$scope.error=response.data*/
				$location.path('/login')
				}			
			console.log(response.data)
			console.log(response.status)
	})
		}
	
	waitlist()
	list()
		})