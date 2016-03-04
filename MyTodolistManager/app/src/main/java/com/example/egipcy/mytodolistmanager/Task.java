package com.example.egipcy.mytodolistmanager;

public class Task
{
    private boolean checked;
    private String name;

    public boolean isChecked()
    {
        return this.checked;
    }

    public void setChecked(boolean bool)
    {
        this.checked = bool;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String str) { this.name = str; }
}
