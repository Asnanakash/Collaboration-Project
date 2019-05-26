myApp.controller("UserController", function($scope, $http, $location, $rootScope, $cookieStore)
{
	$scope.User = {
		'userName' : '',
		'password' : '',
		'customerName' : '',
		'password' : '',
		'emailId' : '',
		'role' : '',
		'status' : '',
		'isOnline' : ''};

	$scope.register = function() 
	{
		console.log('I am in Register Function');
		$scope.User.role = 'Student';
		$scope.User.status = 'NA';
		$scope.User.isOnline = 'ON';
		console.log('The User Details are:');
		console.log($scope.User);
		
		$http.post('http://localhost:8012/CollaborationMiddleWare/registerUser', $scope.User)
		.then(function(response){
			console.log('Registered');
			$location.path('/login');
		})
		
	}

	

	$scope.logincheck = function()
	{
		console.log('I am in Login Function');
		
		$http.post('http://localhost:8012/CollaborationMiddleWare/checkLogin', $scope.user)
		.then(function(response) {
			console.log('Login checked');
			$scope.User=response.data;
						$rootScope.currentUser = response.data;
						console.log($rootScope.currentUser);
						$cookieStore.put('UserDetails',	$rootScope.currentUser);
						$location.path('/userhome');
							});

	}

	
		$scope.logout = function()
	{
		console.log('I am in logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path('/logout');
	}
});