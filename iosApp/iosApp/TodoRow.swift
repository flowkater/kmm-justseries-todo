//
//  TodoRow.swift
//  iosApp
//
//  Created by flowkater on 2023/03/04.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TodoRow: View {
    var todo: Todo
    
    var body: some View {
        HStack() {
            VStack() {
                Text("\(todo.title)")
                Text("\(todo.description())")
            }
        }
    }
}
//
//struct TodoRow_Previews: PreviewProvider {
//    static var previews: some View {
//        TodoRow(todo: <#T##Todo#>(id: 1, title: "todo"))
//    }
//}
