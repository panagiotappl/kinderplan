
router.controller('listEventsController', function($state, $scope, $cookies, $stateParams, EventsService) {
    console.log($stateParams);

    var request = {};
    if($stateParams.query !== undefined)
        request.text = $stateParams.query;
    if($stateParams.lat !== undefined)
        request.lat = $stateParams.lat;
    if($stateParams.lon !== undefined)
        request.lon = $stateParams.lon;
    if($stateParams.start !== undefined)
        request.date_starting = $stateParams.start;
    if($stateParams.end !== undefined)
        request.date_ending = $stateParams.end;
    if($stateParams.dist !== undefined)
        request.distance = parseInt($stateParams.dist);
    console.log(request);
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