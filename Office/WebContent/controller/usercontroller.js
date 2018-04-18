app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore,MsgService)
		{
	$scope.register=function(){
		/*console.log("USER DATA IS"+$scope.user.password)*/
		UserService.register($scope.user).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/home')
			
		},function(response){
			console.log(response.data)
			console.log(response.status)
			$scope.error=response.data
			
				
			$location.path('/register')
		}
		)	}
	
	$scope.login=function(){
		console.log($scope.user)
		UserService.login($scope.user).then(function(response){
		console.log(response.data)
		console.log(response.status)
		$rootScope.currentUser=response.data //username
		$cookieStore.put('currentUser',response.data)
		$location.path('/home')
		
	},function(response){
		console.log(response.data)
		console.log(response.status)
		$scope.error=response.data
	console.log(response.status)
    	 $location.path('/login')
	})
	}
	
	function userlist() {
		UserService.userlist().then(function(response) {
			console.log(response.data)
			console.log(response.status)
			 
			$scope.friends = response.data
		
		}, function(response) {
			console.log(response.status)
			console.log(response.data)
		})
	}
	
	$scope.update=function(){
		console.log("USER DATA IS"+$scope.user.password)
		UserService.update($scope.user).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/home')
			
		},function(response){
			console.log(response.data)
			console.log(response.status)
		
			$location.path('/register')
		}
		)	}
	
	if($rootScope.currentUser!=undefined){
		UserService.details().then(function(response){
			$scope.user=response.data
		},function(response){
			console.log(response.status)
			if(response.status==401){
				delete $rootScope.currentUser;
				$cookieStore.remove('currentUser')
				$location.path('/login')

			}
				
			})
		}
	
	MsgService.getmessage().then(function(response) {
		console.log(response.data)
		console.log(response.status)
		 
		$scope.msg1 = response.data
		$rootScope.noOfmsg=$scope.msg1.length
		console.log("list"+$rootScope.noOfmsg)
	}, function(response) {
		console.log(response.status)
		if(response.status==401){
    	
			$location.path('/login')
		}
	})
	
	userlist()
		})