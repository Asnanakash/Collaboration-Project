myApp.factory('JobService',function($http)
		{
	
	var jobService={};
	const SERVER_URL="http://localhost:8012/CollaborationMiddleWare";
	
	jobService.addJob=function(job)
	{
		return $http.post(SERVER_URL+"/addJob",job);
	}
	
	jobService.getAllJobs=function()
	{
	
		return $http.get(SERVER_URL+"/getJobDetails");
	}
	
	return jobService;
	
	
})