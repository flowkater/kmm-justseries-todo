import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
	let greet = Greeting().greet()

	var body: some View {
        NavigationView {
            listView()
                .navigationTitle("Todo App")
                .navigationBarItems(trailing:
                    Button("AddTodo") {
                        self.viewModel.addTodo()
                })
        }
	}
    
    private func listView() -> AnyView {
        switch viewModel.todos {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let todos):
            return AnyView(List(todos) { todo in
                TodoRow(todo: todo)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {
    enum LoadableTodos {
        case loading
        case result([Todo])
        case error(String)
    }
    
    
    class ViewModel: ObservableObject {
        let service: TodoSDK
        @Published var todos = LoadableTodos.loading

        init(service: TodoSDK) {
            self.service = service
            self.loadTodos()

        }

        func loadTodos() {
            service.getTodos(completionHandler: { todos, error in
                if let todos = todos {
                    self.todos = .result(todos)
                } else {
                    self.todos = .error(error?.localizedDescription ?? "error")
                }
            })
        }
        
        func addTodo() {
            service.addTodo(todoDTO: TodoDTO(title: "todo"), completionHandler: { todos, error in
                if let todos = todos {
                    self.todos = .result(todos)
                } else {
                    self.todos = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}

extension Todo: Identifiable {
    
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView(viewModel: .init(service: TodoSDK(databaseDriverFactory: DatabaseDriverFactory())))
	}
}
