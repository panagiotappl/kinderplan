router.controller('publicProfileController', function($scope, $cookies,$stateParams, $state, UserService){
    var id = $stateParams.id;

    $scope.user = {};
    $scope.events = {};
    $scope.hasEvents = false;

    UserService.getProfile(id)
        .then(function(response) {
            console.log(response);
            $scope.user = response.data;
            if (response.data.provider.events.length === 0){
                $scope.hasEvents = false;
            }else {
                $scope.hasEvents = true;
                $scope.events = response.data.provider.events;
            }
        }, function(response){
            console.log(response);
        });


    $scope.getevent = function(id){
        $state.go('event', {id: id});
    };


});