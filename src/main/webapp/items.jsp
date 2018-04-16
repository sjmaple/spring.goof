<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Grocery List</title>
        <style>
            body{
                 font-family: verdana;
            }

            table {
                width: 500px;

            }

            table, th, td {
                border: 1px solid black;
                padding: 2px;
            }

            th{
                background-color: #00439A;
                color : #FFFFFF;
            }

            tr.odd{
                background-color: #CFCFCF;
            }

            tr.even{
                background-color: #1076F5;
            }
        </style>
    </head>
    <body>
    <h1>Grocery List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Item name</th>
            <th>Item cost</th>
        </tr>
        <s:iterator value="items">
        <tr class="<s:if test="id%2==0">even</s:if><s:else>odd</s:else>">
            <td align="center"><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="cost"/></td>
        </tr>
        </s:iterator>
        </table>
    </body>
</html>
