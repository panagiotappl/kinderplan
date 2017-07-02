
router.controller('listEventsController', function($state, $scope, $cookies, $stateParams, EventsService) {

    EventsService.search($stateParams.query)
        .then( function (response){
            console.log(response);
            $scope.events = response.data;
        }, function(response){
            console.log(response);
        });



    $scope.getevent = function(id){
        $state.go('event', {id: id});
    }
});