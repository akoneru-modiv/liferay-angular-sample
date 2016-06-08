angular.
    module('phoneCatApp').
    factory('PhoneService', function($http){
        var PhoneService = {
            getTransactions: function(accountId, accountType){
                console.log("getting service module");
                var data = {accountId: '9557850', accountType: 'P'};
                return $http.get({
                    method: 'GET',
                    url: PhoneConfig.ajaxUrl + "&p_p_resource_id=testList",
                    params: data
                }).then(function(response){
                    return response.data; 
                });
            }
        };
        return PhoneService;
    });