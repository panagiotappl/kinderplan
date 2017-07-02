router.controller('eventController', function($scope, $cookies, $stateParams, EventsService, UserService){

    var id = $stateParams.id;
    console.log($stateParams.id);

        EventsService.getevent(id)
            .then(function(response){
                console.log(response);
                $scope.event = response.data;
                $scope.event.date_starting = new Date($scope.event.date_starting);
                $scope.event.date_ending = new Date($scope.event.date_ending);
            }, function (response){
                console.log(response);
            });


});
