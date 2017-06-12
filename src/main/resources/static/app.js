var router = angular.module('router', [ 'ui.router', 'ui.bootstrap', 'ngCookies', 'ngMessages', 'ngAutocomplete',"ngAnimate","ngAria", 'ngMaterial', 'moment-picker', 'lr.upload']);


router.run([
    '$log', '$rootScope', '$window', '$state', '$location',
    function($log, $rootScope, $window, $state, $location) {
        $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
            if (toState.data.pageTitle ) {
                document.title = toState.data.pageTitle + ' | KinderPlan';

            }else
                document.title = 'KinderPlan';
        });
    }
]);
