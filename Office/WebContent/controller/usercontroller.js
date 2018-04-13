app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore)
		{
	$scope.register=function(){
		console.log("USER DATA IS"+$scope.user.password)
		UserService.register($scope.user).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/home')
			
		},function(response){
			console.log(response.data)
			console.log(response.status)
			/*$scope.error.response.data
			if($scope.error.code==1)
				$scope.exception=response.data
				if($scope.error.code==2)
					$scope.duplicateUser=response.data
					if($scope.error.code==3)
						$scope.duplicateEmail=response.data*/
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
	
		})