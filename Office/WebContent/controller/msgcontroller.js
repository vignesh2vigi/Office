/**
 * 
 */
app.controller('MsgController',function($scope,MsgService,$location,$routeParams,$rootScope)
		{
	var sno=$routeParams.sno
	
	
	
MsgService.friend(sno).then(function(response){
		
		$scope.msg=response.data
		
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	$scope.send=function(){	
		
	
	MsgService.addmsg($scope.msg).then(function(response){
			console.log(response.data)
			console.log(response.status)
			/*alert('Updated successfully')*/
			
			$location.path('/friends')
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
	
	
	
		})