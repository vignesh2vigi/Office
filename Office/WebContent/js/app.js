/**
 * 
 */
var app = angular.module("app", [ 'ngRoute','ngCookies'])
app.config(function($routeProvider) {

	$routeProvider
	.when("/register", {
        templateUrl : 'view/register.html',
        controller:'UserController'
        })
    .when("/home", {
        templateUrl : 'view/home.html',
        controller:'UserController'
        })
        .when("/login", {
        templateUrl : 'view/login.html',
        controller:'UserController'
        })
        .when("/addblog", {
        templateUrl : 'view/bloglist.html',
        controller:'BlogController'
        })
        .when("/getblog", {
        templateUrl : 'view/bloglist.html',
        controller:'BlogController'
        })
        .when('/uploadprofilepic', {
		templateUrl : 'view/profilepicture.html'
	})
	.when('/friends', {
		templateUrl : 'view/friends.html',
		controller:'UserController'
	})
	.when('/message/:sno', {
		templateUrl : 'view/message.html',
		controller:'MsgController'
	})
        .when("/about", {
        templateUrl : 'view/about.html'
        
        })
    .otherwise("/home",{templateurl:"view/home.html",controller:'UserController'})
   	
})

app.run(function($rootScope,$cookieStore,$location,UserService){
	
		if($rootScope.currentUser==undefined){
			$rootScope.currentUser=$cookieStore.get('currentUser')
		}
		$rootScope.logout=function(){
			
			UserService.logout().then(function(response){
			delete $rootScope.currentUser;
			console.log(response.status)
			console.log(response.data)
			$cookieStore.remove('currentUser')
			$location.path('/login')
			
		},function(response){
			if(response.status==401){
				console.log(response.status)
				console.log(response.data)
				delete $rootScope.currentUser;
				$cookieStore.remove('currentUser')
				$location.path('/login')

			}
				
		})
	}

})
