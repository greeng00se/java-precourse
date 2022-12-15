package controller;

import static util.Retry.execute;

public abstract class AbstractController implements Controller {

    @Override
    public void run() {
        execute(this::process);
    }

    protected abstract void process();
}
