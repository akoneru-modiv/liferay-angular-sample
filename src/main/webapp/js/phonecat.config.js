angular.
    module('phoneCatApp').
    config(['$locationProvider' ,'$routeProvider',
        function config($locationProvide, $routeProvider){
            $locationProvider.hashPrefix('!');
            
            $routeProvider.
                when('/transaction', {
                    template: '<phone-list></phone-list>'
                }).otherwise('/transaction');
        }
    ]);