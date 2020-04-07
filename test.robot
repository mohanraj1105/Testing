*** Variables ***
@{side}    1,2,3,4,5

*** Test Cases ***
test condition
    [Tags]    test
    '2' should in the list

*** Keywords ***
'${value}' should in the list
       should be equal as strings  @{@{side}[0]}[1]   ${value}
