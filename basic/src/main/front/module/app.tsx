import * as React from "react";
import PostView, { Post } from "./post"
import PostForm from "./post-form"
import Store from "./store"
type ApplicationState = {
  posts: Post[]
}
class App extends React.Component<never, ApplicationState>{
  state = { posts: [] as Post[] }
  store = new Store()
  componentDidMount() {
    this.store.subscribe("reflesh", (posts) => {
      this.setState({ posts })
    })
    this.store.load()
  }
  post = (content: Post.Content) => {
    this.store.add(content)
  }
  deletePost = (post: Post) => {
    this.store.delete(post)
  }
  render() {
    return <div className="columns application">
      <div className="column is-one-quarter">
        <PostForm post={this.post} />
      </div>
      <div className="column tile posts">
        {this.state.posts.map((p) => <PostView key={p.id} deletePost={this.deletePost} {...p}></PostView>)}
      </div>
    </div>
  }
}
export default App;