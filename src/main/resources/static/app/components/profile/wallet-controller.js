router.controller('walletController', function($scope, $cookies, $state, UserService){
    $scope.user = {};
    $scope.parent = false;
    $scope.provider = false;
    $scope.selected = false;

    $scope.items = [{
        id: 1,
        label: '10 points for: 5 €',
        price: 5,
        quantity: 10
    }, {
        id: 2,
        label: '20 points for: 10 €',
        price: 10,
        quantity: 20
    }, {
        id: 3,
        label: '50 points for: 25 €',
        price: 25,
        quantity: 50
    }, {
        id: 4,
        label: '100 points for: 50 €',
        price: 50,
        quantity: 100
    }];


    $scope.discount = [ {
        id: 1,
        label: '200 points for: 80 € (Reg. 100 €)',
        price: 80,
        quantity: 200
    },  {
        id: 2,
        label: '300 points for: 120 € (Reg. 150 €) ',
        price: 120,
        quantity: 300
    }];



    if($cookies.get('signedIn') === 'yes'){
        $scope.signedIn = true;
        $scope.user.userId = $cookies.get('id');
        $scope.user.authToken = $cookies.get('authToken');

        console.log($scope.user.authToken);
        UserService.getuser($scope.user.userId ,$scope.user.authToken)
            .then(function(response){
                $scope.user = response.data;
                $scope.user.authToken = $cookies.get('authToken');

                console.log($scope.user);
                if($scope.user.parentDto != null)
                    $scope.parent = true;
                else
                    $scope.provider = true;
            }, function(response){
                $scope.signedIn = false;
                $state.go('notValid');

            });
    }else{
        $state.go('notValid');
    }

    $scope.selection = {};

    $scope.select = function(id, type){
        $scope.selected = true;
        if(type === "normal")
            $scope.selection = $scope.items[id - 1];
        else $scope.selection = $scope.discount[id - 1];
    }

    $scope.pay = function(){
        console.log($scope.user.authToken);
        UserService.pay($scope.user.id, $scope.user.authToken, $scope.selection.quantity)
            .then(function(response){

            }, function(response){

            })

    }

});