
router.controller('listEventsController', function($state, $scope, $cookies, $stateParams, EventsService) {
    console.log($stateParams);

    var request = {};
    request.text = $stateParams.query;
    request.lat = $stateParams.lat;
    request.lon = $stateParams.lon;
    request.date_starting = parseInt($stateParams.start);
    request.date_ending = parseInt($stateParams.end);
    request.distance = parseInt($stateParams.dist);
    EventsService.search(request)
        .then(function(response){
            $scope.events = response.data;
        }, function(response){
            console.log(response);
        });



    $scope.getevent = function(id){
        $state.go('event', {id: id});
    }
});