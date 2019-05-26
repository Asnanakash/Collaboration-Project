myApp.controller("BlogCommentController",function($scope, $http, $location, $rootScope, $cookieStore)
{
	$scope.blogComment={'id':0,'blogId':0,'blogComment':'','userId':'','commentdate':'','userName':''}
	$scope.blogComments;
	
	/*$scope.addComment=function()
	{
		$scope.blogComment.blogId=$rootScope.blogInfo.blogId;
		$scope.blogComment.userName=$rootScope.currentUser.username;
		
		$http.post('http://localhost:8012/CollaborationMiddleWare/addBlogComment',$rootScope.blogInfo)
		 $then(function(response)
		 {
			 
		 });
		
		
	}
	*/
	
	
	
	$scope.addComment=function()
	{
		console.log('I am in adding BlogComment');
		
		
       $scope.blogComment.blogId=$rootScope.blogInfo.blogId;
       $scope.blogComment.userName=$rootScope.currentUser.username;
		
      $http.post('http://localhost:8012/CollaborationMiddleWare/addBlogComment',$scope.blogComment)
      $then(function(response)
     {
	 
    	  
			console.log('BlogComment Added');
			console.log(response.data);
     });
				
		
		
	}
	
	$scope.deleteComment=function(blogId)
	{
		console.log('I am in deleting BlogComment');
		
		
       
		
      $http.post('http://localhost:8012/CollaborationMiddleWare/deleteBlogComment',$scope.blogComment)
      $then(function(response)
     {
	 
    	  
			console.log('BlogComment deleted');
			console.log(response.data);
     });
				
		
		
	}
	
 function loadBlogComment()
 {
	 /*$http.get('http://localhost:8012/CollaborationMiddleWare/getBlogComments/'+$rootScope.blogInfo.blogId)
	 $then(function(response)
	 {
		 
		 $rootScope.blogComments=response.data;
       	 	
       	 });*/
 }

 loadBlogComment();
});

