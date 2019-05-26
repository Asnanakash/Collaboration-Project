myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
    $scope.friend={'friendId':0,'username':'','friendUserName':'','status':''};	
    $scope.User={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''};
    
    $scope.friendList;
    
    function showFriendList()
    {
    	console.log('I am in ShowFriendList');
    	console.log($rootScope.currentUser.username);
    	$http.get('http://localhost:8012/CollaborationMiddleWare/showFriendList/'+$rootScope.currentUser.username)
    	.then(function(response){
    		$scope.friendList=response.data;
    		console.log($scope.friendList);
    	
    
        });
    	
    	
     }
    
    function showPendingFriendList()
    {
    	console.log('I am in ShowPendingFriendList');
    	console.log($rootScope.currentUser.username);
    	$http.get('http://localhost:8012/CollaborationMiddleWare/showPendingFriendList/'+$rootScope.currentUser.username)
    	.then(function(response){
    		$scope.pendingFriendList=response.data;
    		console.log($scope.pendingFriendList);
    	
    
        });
    }
    
    function showSuggestedFriendList()
    {
    	console.log('I am in ShowSuggestedFriendList');
    	console.log($rootScope.currentUser.username);
    	$http.get('http://localhost:8012/CollaborationMiddleWare/showSuggestedFriendList/'+$rootScope.currentUser.username)
    	.then(function(response)
    	{
    		$scope.suggestedFriendList=response.data;
    		console.log($scope.suggestedFriendList);
    	
    
        });
    }
    
    $scope.unfriend=function(friendId)
    {
    	
    	console.log('Unfriend Implementation');
    	$http.get('http://localhost:8012/CollaborationMiddleWare/deleteFriendRequest/'+ friendId)
    	,then(function(response){
    		
    		$scope.log('Friend Deleted');
    	})
    }
    
    $scope.accept=function(friendId)
    {
    	
    	console.log('Accept Friend Implementation');
    	$http.get('http://localhost:8012/CollaborationMiddleWare/acceptFriendRequest/'+ friendId)
    	.then(function(response){
    		
    		$scope.log('Friend Request Accepted');
    	
    	
    	});
    }
    
    $scope.friendRequest=function(fusername)
    {
    	/*$scope.friend.username=$rootScope.currentUser.username;*/
    	console.log("entered in sending Friend Request");
    	$scope.friend.friendUserName=fusername;
    	$scope.friend.username=$rootScope.currentUser.username;
    	console.log("Current User:"+$rootScope.currentUser.username);
		console.log("Sending friend fusername");
    	$http.post('http://localhost:8012/CollaborationMiddleWare/sendFriendRequest',$scope.friend)
    	.then(function(response)
    	{
    		$scope.log('Friend Request Sent');
    	});
    	
    }
    
    showFriendList();
    showPendingFriendList();
    showSuggestedFriendList()
});