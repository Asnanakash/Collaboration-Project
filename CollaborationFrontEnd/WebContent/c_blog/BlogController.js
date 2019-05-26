myApp.controller("BlogController",function($scope, $http, $location, $rootScope, $cookieStore,$route,$routeParams)
{
	
	$scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0};
	$scope.blogData;
	$rootScope.blogInfo;
	
	$scope.blogComment={'id':0,'blogId':'','blogComment':'','commentDate':'','userId':'','userName':''}
	$scope.blogComments;
	

	
	
	$scope.addBlog=function()
	{
		console.log('I am in adding Blog');
		
		$scope.blog.username=$rootScope.currentUser.username;
		$scope.blog.status='NA';
		
		$http.post('http://localhost:8012/CollaborationMiddleWare/addBlog',$scope.blog)
		.then(function(response)
				
		{
			$("#addBlogModal").modal("hide");
			$("#addBlogSuccessfulModal").modal("show");
			console.log('Blog Added');
			console.log(response.data);
		});
	}
	
	function loadBlog()
	{
		console.log('Loading All Blogs');
		$http.get('http://localhost:8012/CollaborationMiddleWare/getBlogDetails')
		.then(function(response)
				{
			console.log('Loading Blog');
			$scope.blogData=response.data;
			console.log($scope.blogData);
			
	       	
	});
	}
	
	$scope.incrementLikes=function(blogId)
	{
		console.log('Increment Like');
		$http.get('http://localhost:8012/CollaborationMiddleWare/incrementLikes/'+blogId)
         .then(function(response)
        		 {
        	 
        		 });
	}
	
	$scope.incrementDisLikes=function(blogId)
	{
		console.log('Increment DisLike');
		$http.get('http://localhost:8012/CollaborationMiddleWare/incrementDisLikes/'+blogId)
         .then(function(response)
        		 {
        	 
        		 });
	}
	
	$scope.approveBlog=function(blogId)
	{
		console.log('Approving Blog');
		$http.get('http://localhost:8012/CollaborationMiddleWare/approveBlog/'+blogId)
        .then(function(response)
       		 {
       	 
       		 });
		
	}
	
	$scope.rejectBlog=function(blogId)
	{
		console.log('Rejecting Blog');
		$http.get('http://localhost:8012/CollaborationMiddleWare/rejectBlog/'+blogId)
        .then(function(response)
       		 {
       	 
       		 });
		
	}
	
	$scope.deleteBlog=function(blogId)
	{
		console.log('Deleting Blog');
		$http.get('http://localhost:8012/CollaborationMiddleWare/deleteBlog/'+blogId)
        .then(function(response)
       		 {
        	console.log('Blog Deleted');
			console.log(response.data);
       		 });
		
	}
	
	$scope.showBlog=function(blogId)
	{
		console.log('Showing Details of Blog');
		$http.get('http://localhost:8012/CollaborationMiddleWare/getBlog/'+blogId)
        .then(function(response)
       		 {
       	 $rootScope.blogInfo=response.data;
       	 console.log($rootScope.blogInfo);
       	 $location.path('/showBlogDetail');
       		 });
		 console.log('Showing Blog Comment');
		$http.get('http://localhost:8012/CollaborationMiddleWare/getBlogComments/'+blogId)
		 .then(function(response)
				 {
			
			 $rootScope.blogComments=response.data;
				 });
		
	}
	
	$scope.editBlog=function(blogId)
	{
		console.log('I am in Edit Blog');
		$http.get('http://localhost:8012/CollaborationMiddleWare/getBlog/'+blogId)
        .then(function(response)
       		 {
       	 $rootScope.blogInfo=response.data;
       	 console.log($rootScope.blogInfo);
       	 $location.path('/updateBlogDetail');
       		 });
	}
	
	$scope.updateBlog=function()
	{
		console.log('I am in update Blog');
		$scope.blog=$rootScope.blogInfo;
		$http.post('http://localhost:8012/CollaborationMiddleWare/updateBlog'+blogId)
		.then(function(response)
				{
			      console.log('Blog is Updated');
			      $location.path('/showBlogDetail');
				});
		
		
	}
	
	/*$scope.showComment=function(blogId)
	{
		console.log('Show Comment Method');
		$rootScope.blogId=blogId;
		$location.path("/blogComment");
	},
	function (error){
		console.log("Erroe:"+error);
	}*/
	
	
 /*function loadBlogComment()
 {
	 $http.get('http://localhost:8012/CollaborationMiddleWare/getBlogComments/'+$scope.blogId)
	 $then(function(response)
	 {
		 
		 $rootScope.blogComments=response.data;
       	 	
       	 });
 }
*/
 
	
		loadBlog();
		
        
	});